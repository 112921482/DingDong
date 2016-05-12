<div id="modal-release-form" class="modal fade" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form role="form" action="releaseMenu" method="post">
                    <div class="wrapper wrapper-content animated fadeIn">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>发布菜单</h5>
                                    </div>

                                    <div class="ibox-content">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>菜品名称</th>
                                                <th>价格（元）</th>
                                                <th>备货数量（份）</th>
                                                <th>出售价格（元）</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <g:each in="${selectedMenuList}" var="selectedMenu">
                                                <tr>
                                                    <td style="display: none;"><g:hiddenField name="selectedMenuId"
                                                                                              value="${selectedMenu.getId()}"/></td>
                                                    <td>${selectedMenu.getName()}</td>
                                                    <td>${selectedMenu.getPrice()}</td>
                                                    <td>
                                                        <input type="number" min="1" step="1" value="1"
                                                               name="selectedMenu.${selectedMenu.getId()}.sellAmount"
                                                               style="width: 60px;" required>
                                                    </td>
                                                    <td>
                                                        <input type="number" min="0.00" step="0.01"
                                                               value="${selectedMenu.getPrice()}"
                                                               name="selectedMenu.${selectedMenu.getId()}.sellPrice"
                                                               style="width: 60px;" required>
                                                    </td>
                                                </tr>
                                            </g:each>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div>
                                    <button class="btn btn-sm btn-primary pull-right m-t-n-xs" id="submitBtn"
                                            type="submit"><strong>提交</strong></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

