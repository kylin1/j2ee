<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="membership"/>
</jsp:include>

<body>

<div class="wrapper">
  <!--整个左侧导航栏-->
  <%@include file="guest-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">
    <!--1.导航栏-->
    <%@include file="guest-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">

        <!--第一部分:个人信息-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">会员卡信息</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form>
                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">账号</label>
                    </div>

                    <div class="col-md-4">
                      <p class="card-text">一只麟</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">状态</label>
                    </div>
                    <div class="col-md-4">
                      <p class="text-success card-text">已激活</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">激活时间</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">2017-10-10</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">到期时间</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">2018-10-10</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">累计消费</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">￥3780</p>
                    </div>
                    <div class="col-md-2">
                      <label class="control-label">会员卡余额</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">￥900</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">会员级别</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">高级会员</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">积分</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">3000</p>
                    </div>

                  </div>

                  <div class="row">
                    <div class="col-md-3">
                      <button type="submit" class="btn btn-primary pull-left">
                        会员充值
                      </button>
                    </div>

                    <div class="col-md-3">
                      <button type="submit" class="btn btn-danger pull-left">
                        取消资格
                      </button>
                    </div>
                  </div>
                  <div class="clearfix"></div>
                </form>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

</html>