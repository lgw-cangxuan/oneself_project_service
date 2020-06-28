<template>
  <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
    <div class="background">
      <img src="../../static/imgs/login_background.jpg" width="100%" height="100%" alt="" />
    </div>
    <div class="front">
      <h1>car忘记密码</h1>
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
        <span class="forget"><router-link to="/">登录系统!</router-link></span>
        <br>
        <span class="forget"><router-link to="register">注册账号!</router-link></span>
      </div>
    </div>
  </Form>
</template>
<script>
  export default {
    data() {
      return {
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
  h1{
    margin-bottom: 20px;
    margin-left: -10px;
  }
  #button{
    width: 190px;
  }
  #three{
    color: blue;
    margin-top: -10px;
  }
  .forget{
    margin-left: 120px;
  }
  .background{
    width:100%;
    height:100%;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
  }
  .front{
    z-index:1;
    width: 400px;
    height: 350px;
    position: absolute;
    left: 50%;
    top: 50%;
    margin-top: -175px;
    margin-left: -200px;
    background-color: #ffffff;
    padding-top: 20px;
    opacity: 0.7;
    border-radius: 5px;
  }
</style>
