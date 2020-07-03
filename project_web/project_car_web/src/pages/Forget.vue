<template>
  <Form ref="formInline" :model="formInline" :rules="ruleInline" inline :style="background" inline class="background">
    <div class="forget_front">
      <h1>重置密码</h1>
      <div>
        <FormItem prop="phone">
          <Input type="text" v-model="formInline.phone" placeholder="电话号码">
          <Icon type="ios-person-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
      </div>
      <div>
        <FormItem prop="password">
          <Input type="password" v-model="formInline.password" placeholder="密码">
          <Icon type="ios-lock-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
      </div>
      <div>
        <FormItem prop="newPassword">
          <Input type="password" v-model="formInline.newPassword" placeholder="新密码">
          <Icon type="ios-lock-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
      </div>
      <div>
        <FormItem>
          <Button type="primary" @click="handleSubmit('formInline')" id="button">重置</Button>
        </FormItem>
      </div>
      <div id="three">
        <span class="login"><router-link to="/">登录系统!</router-link></span>
        <span class="register"><router-link to="register">注册账号!</router-link></span>
      </div>
    </div>
  </Form>
</template>
<script>
  export default {
    data() {
      return {
        background: {
          backgroundImage: "url(" + require("../../static/imgs/login_background.jpg") + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize: "100% 100%"
        },
        formInline: {
          phone: '',
          password: '',
          newPassword: ''
        },
        ruleInline: {
          phone: [
            {required: true, message: '请填写手机号', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请填写密码', trigger: 'blur'},
            {
              type: 'string',
              min: 3,
              message: '密码长度不能少于3位',
              trigger: 'blur'
            }
          ],
          newPassword: [
            {required: true, message: '请填写新密码', trigger: 'blur'},
            {
              type: 'string',
              min: 6,
              message: '新密码长度不能少于6位',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.$axios({
              url: 'login/forget',//请求的地址
              method: 'post',//请求的方式
              data: this.formInline//请求的表单数据
            }).then(res => {
              this.$router.push('/');
            }).catch(err => {
              this.$Message.error(err.response.data.message);
            });
          } else {
            this.$Message.error('表单校验失败!');
          }
        })
      }
    }
  }
</script>

<style type="text/css">
  /*背景*/
  .background{
    height: 100%;
  }
  .forget_front{
    width: 400px;
    height: 350px;
    background-color: #ffffff;
    opacity: 0.7;
    border-radius: 5px;
    position:fixed;
    top:50%;
    left:50%;
    transform:translate(-50%,-50%);
  }

  h1{
    margin-top: 20px;
    margin-bottom: 10px;
  }
  #button{
    width: 190px;
  }
  .login{
    margin-left: -10px;
  }
  .register{
    margin-left: 80px;
  }
</style>
