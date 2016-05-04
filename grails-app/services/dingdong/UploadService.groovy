package dingdong

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class UploadService {

    def grailsApplication

    def uploadPic(List<MultipartFile> picFiles) {
        def rs = true
        def savePathList = []
        String filePath = grailsApplication.config.getProperty('picSavePath')
        //判断文件夹是否存在，不存在则创建
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (IOException ex) {
                log.error(ex.getMessage())
                rs = false
            }
        }

        picFiles.each { picFile ->
            if (rs) {
                try {
                    Date d = new Date();
                    String dateString = d.format("yyyymmddhhmmssSSS")
                    //获得原始文件名
                    String fileProName = picFile.getOriginalFilename()
                    //获得文件后缀
                    String picSuffix = fileProName.split('\\.')[-1]
                    def fileName = dateString + "." + picSuffix
                    def savePath = filePath + fileName
                    picFile.transferTo(new File(savePath))
                    savePathList << fileName
                } catch (Exception ex) {
                    log.error(ex.getMessage())
                    rs = false
                }
            }
        }
        [
                result      : rs,
                savePathList: savePathList
        ]
    }
}
