<template>
  <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
    <div class="background">
      <img src="../../static/imgs/login_background.jpg" width="100%" height="100%" alt="" />
    </div>
    <div class="front">
      <h1>car系统注册</h1>
      <div>
        <FormItem prop="nike">
          <Input type="text" v-model="formInline.nike" placeholder="昵称">
          <Icon type="ios-person-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
      </div>
      <div>
        <FormItem prop="name">
          <Input type="text" v-model="formInline.name" placeholder="姓名">
          <Icon type="ios-person-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
      </div>
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
        <FormItem>
          <Button type="primary" @click="handleSubmit('formInline')" id="button">注册</Button>
        </FormItem>
      </div>
      <div id="three">
        <span class="forget"><router-link to="/">登录系统!</router-link></span>
        <br>
        <span class="forget"><router-link to="forget">忘记密码?</router-link></span>
      </div>
    </div>
  </Form>
</template>
<script>
  export default {
    data() {
      return {
        formInline: {
          nike: '',
          name: '',
          phone: '',
          password: ''
        },
        ruleInline: {
          nike: [
            {required: true, message: '请填写昵称', trigger: 'blur'}
          ],
          name: [
            {required: true, message: '请填写姓名', trigger: 'blur'}
          ],
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
          ]
        }
      }
    },
    methods: {
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.$axios({
              url: 'login/register',//请求的地址
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
    height: 400px;
    position: absolute;
    left: 50%;
    top: 50%;
    margin-top: -200px;
    margin-left: -200px;
    background-color: #ffffff;
    padding-top: 20px;
    opacity: 0.7;
    border-radius: 5px;
  }
</style>
