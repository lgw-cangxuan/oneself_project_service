<template>
  <nav>
    <!-- 登录|注册 -->
    <div class="log_register">
      <router-link to="/" class="login" onMouseOut="this.style.color=''" onMouseOver="this.style.color='#ff0000'">登录</router-link> |
      <router-link to="register" onMouseOut="this.style.color=''" onMouseOver="this.style.color='#ff0000'">注册</router-link> |
      <router-link to="chat" onMouseOut="this.style.color=''" onMouseOver="this.style.color='#ff0000'">交流</router-link>
    </div>
    <!-- 搜索栏 -->
    <div class="top">
      <input type="text" class="search">
      <button class="search_button" onMouseOut="this.style.backgroundColor=''" onMouseOver="this.style.backgroundColor='#2e4ecf'">搜索</button>
    </div>
    <!-- 导航栏 -->
    <div class="indexNavOut">
      <div class="indexNav">
        <ul class="navLi">
          <li v-bind:class="">
            <router-link to="/">测评</router-link>
          </li>
          <li v-bind:class="">
            <router-link to="/">文章</router-link>
          </li>
          <li v-bind:class="">
            <router-link to="/">选车</router-link>
          </li>
          <li v-bind:class="">
            <router-link to="/">图片</router-link>
          </li>
          <li v-bind:class="">
            <router-link to="/">车型对比</router-link>
          </li>
          <li v-bind:class="">
            <router-link to="/">论坛</router-link>
          </li>
        </ul>
      </div>
    </div>
    <!-- 主部分 -->
    <div>
        <div>

        </div>
    </div>
  </nav>
</template>

<script>
  export default{
    data()
    {
      return{

      }
    }
  }
</script>
<style type="text/css">
  /* 导航栏 */
  .login{
    margin-left: 85%;
  }
  .log_register{
    margin-top: 20px;
  }

  .top{
    height: 100px;
    margin-top: 30px;
  }

  .search{
    height: 40px;
    width: 400px;
    border-radius: 10px 0px 0px 10px;
    border:solid #4e6ef2;
    outline: none;
    text-indent:15px
  }

  .search_button{
    height: 40px;
    margin-top: -2px;
    margin-left: -6px;
    border-radius: 0px;
    background-color: #4e6ef2;
    border-radius: 0px 10px 10px 0px;
    border: 0px;
    width: 100px;
    color: white;
    outline: none;
  }

  .indexNavOut{
    background-color: #3387e6;
    height: 60px;
  }

  .indexNav{
    width: 60%;
    margin: 0 auto;
  }

  .navLi{
    display: flex;

  }

  .navLi li:nth-child(1){
    flex: 1;
  }

  .navLi li{
    flex: 1;
    list-style-type:none;
  }

  .navLi li a{
    text-decoration: none;
    color: #fff;
    font-size: 16px;
    padding-bottom: 17px;
  }

  .indexNav .icon{
    width: 230px;
    margin-top: 10px;
  }

  .indexNav .icon img{
    width: 100%;
  }

  .navLi li {
    height: 60px;
    line-height: 60px;
    position: relative;
  }

  .navLi li.active a{
    border-bottom: 3px solid #E96463;

  }

  .navLi li.active2 a{
    border-bottom: 3px solid #E96463;

  }

  .navLi li:last-child:after{
    border-right: none;
  }

  .navLi li .line{
    width: 20px;
    height: 3px;
    background: #E96463;
    border: none;
    position: absolute;
    left: 50px;
    top: 45px;
    z-index: 100;
  }
</style>
