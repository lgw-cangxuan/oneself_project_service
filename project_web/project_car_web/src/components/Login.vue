<template>
  <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
    <FormItem prop="phone">
      <Input type="text" v-model="formInline.phone" placeholder="Phone">
      <Icon type="ios-person-outline" slot="prepend"></Icon>
      </Input>
    </FormItem>
    <FormItem prop="password">
      <Input type="password" v-model="formInline.password" placeholder="Password">
      <Icon type="ios-lock-outline" slot="prepend"></Icon>
      </Input>
    </FormItem>
    <FormItem>
      <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
    </FormItem>
  </Form>
</template>
<script>
  export default {
    data() {
      return {
        formInline: {
          phone: '',
          password: ''
        },
        ruleInline: {
          phone: [
            {required: true, message: 'Please fill in the user phone', trigger: 'blur'}
          ],
          password: [
            {required: true, message: 'Please fill in the password.', trigger: 'blur'},
            {
              type: 'string',
              min: 6,
              message: 'The password length cannot be less than 6 bits',
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
              url: 'api/login/login',
              method: 'POST',
              data: this.formInline
            }).then(res => {
              if(res.data.status == 'F1006'){
                this.$Message.error(res.data.message);
              }
            }).catch(err => {
              this.$Message.error(err.response.message);
            });
          } else {
            this.$Message.error('表单校验失败!');
          }
        })
      }
    }
  }
</script>
