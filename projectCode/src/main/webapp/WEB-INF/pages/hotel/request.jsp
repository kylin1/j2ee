<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="申请&审批"/>
</jsp:include>

<body>

<div class="wrapper">

  <!--整个左侧导航栏-->
  <%@include file="hotel-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">

    <!--1.导航栏-->
    <%@include file="hotel-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">
        <!--开店申请-->
        <section>
          <h2>开店申请</h2>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">新的申请</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">
                  <form>
                    <!--基本信息-->
                    <div class="row">

                      <div class="col-md-3 dropdown">
                        <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                          酒店级别
                          <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                          <li><a href="#">五星级</a></li>
                          <li><a href="#">四星级</a></li>
                          <li><a href="#">三星级</a></li>
                          <li><a href="#">快捷连锁</a></li>
                        </ul>
                      </div>

                      <div class="col-md-2">
                        <div class="form-group label-floating">
                          <label class="control-label">酒店名称</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">地址</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                    </div>


                    <button type="submit" class="btn btn-primary pull-left">
                      提交申请
                    </button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </section>

        <section>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">添加房间</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">
                  <form>

                    <!--添加房间-->
                    <div class="row">


                      <div class="col-md-3 dropdown">
                        <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                          房间类型
                          <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                          <li><a href="#">标准间</a></li>
                          <li><a href="#">单人间</a></li>
                          <li><a href="#">套房</a></li>
                        </ul>
                      </div>

                      <div class="col-md-2">
                        <div class="form-group label-floating">
                          <label class="control-label">房间号</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">信息</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>
                      <div class="col-md-1" style="padding-top: 40px;">
                        <a href="#" id="add-room-icon2">
                          <i class="material-icons">add_circle_outline</i>
                        </a>
                      </div>
                    </div>


                    <button type="submit" class="btn btn-primary pull-left">
                      提交申请
                    </button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </section>

        <!--修改信息-->
        <section>
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">修改信息</h4>
                  <p class="category"></p>
                </div>
                <div class="card-content">
                  <form>
                    <!--基本信息-->
                    <div class="row">

                      <div class="col-md-3 dropdown">
                        <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                          酒店级别
                          <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                          <li><a href="#">五星级</a></li>
                          <li><a href="#">四星级</a></li>
                          <li><a href="#">三星级</a></li>
                          <li><a href="#">快捷连锁</a></li>
                        </ul>
                      </div>

                      <div class="col-md-2">
                        <div class="form-group label-floating">
                          <label class="control-label">酒店名称</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">地址</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                    </div>

                    <!--其他信息-->
                    <div class="row">

                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">酒店电话</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>

                      <div class="col-md-4">
                        <div class="form-group label-floating">
                          <label class="control-label">法人信息</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>
                    </div>

                    <button type="submit" class="btn btn-primary pull-left">
                      提交申请
                    </button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </section>

        <!--正在审批-->
        <section>
          <h2>正在审批</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">正在审批的申请</h4>
                  <p class="category">开店申请/修改店信息需Hostel World经理审批</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>类别</th>
                    <th>主要内容</th>
                    <th>提交时间</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    <tr>
                      <td>修改客栈信息</td>
                      <td>新增空闲房间</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">详情</a></td>
                    </tr>
                    </tbody>
                  </table>

                </div>
              </div>
            </div>
          </div>
        </section>

        <!--已经通过-->
        <section>
          <h2>已经通过</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">已经通过的申请</h4>
                  <p class="category">Hostel World经理审批过的申请，可以开始执行</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>类别</th>
                    <th>主要内容</th>
                    <th>提交时间</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>开店申请</td>
                      <td>申请加入Hostel World</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">详情</a></td>
                    </tr>

                    </tbody>
                  </table>

                </div>
              </div>
            </div>
          </div>
        </section>

        <!--没有通过-->
        <section>
          <h2>没有通过</h2>
          <div class="row">
            <div class="col-md-10">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h4 class="title">没有通过的申请</h4>
                  <p class="category">Hostel World经理审批过的申请，可以开始执行</p>
                </div>

                <div class="card-content table-responsive">
                  <table class="table">
                    <thead class="text-primary">
                    <th>类别</th>
                    <th>主要内容</th>
                    <th>提交时间</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>开店申请</td>
                      <td>申请加入Hostel World</td>
                      <td>2017年02月13日10:00:59</td>
                      <td><a href="#">详情</a></td>
                    </tr>

                    </tbody>
                  </table>

                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

</html>
