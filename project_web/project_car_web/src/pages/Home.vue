<template>
  <div :style="bgImg" class="bgImg"/>
  </div>
</template>
<script>
  export default {
    name: 'productdetailspage',
    data() {
      return {
        bgImg: {
          backgroundImage: "url(" + require("../../static/imgs/login_background.jpg") + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize: "100% 100%"
        },
      }
    },
  }
</script>
<style type="text/css">
  .bgImg{
    height: 100%;
  }
</style>
