<template>
  <navigation></navigation>
  <router-view />
  <!-- Add a router view -->
</template>

<script>
import Navigation from "./components/Navigation.vue";
export default {
  components: { Navigation },
  name: "App",
  watch: {
    $route: {
      immediate: true,
      handler() {
        document.title = "InHolland Bank";
      },
    },
  },
  created() {
    this.$store.dispatch("autoLogin");
  },
};
</script>

<style>
</style>
