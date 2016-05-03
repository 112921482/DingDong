package dingdong

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class UploadService {

    def uploadPic(MultipartFile picFile) {
        def rs = true
        def fileName
        def filePath
        if (picFile != null) {
            try {
                Date d = new Date();
                String dateString = d.format("yyyymmddhhss")
                //获得原始文件名
                String fileProName = picFile.getOriginalFilename()
                //获得文件后缀
                String picSuffix = fileProName.split('\\.')[-1]
                fileName = dateString + "." + picSuffix
                filePath = "E:/images/"
                picFile.transferTo(new File(filePath + fileName))
            } catch (Exception ex) {
                log.error(ex.getMessage())
                rs = false
            }
        }
        return rs
    }
}
