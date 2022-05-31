<template>
  <router-view />
  <!-- Add a router view -->
</template>

<script>

export default {
  name: "App",
  watch: {
    $route: {
      immediate: true,
      handler() {
        document.title = "InHolland Bank";
      },
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
