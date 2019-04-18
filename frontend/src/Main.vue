
<template>
  <div class="log">
    <router-link to="/"></router-link>
    <router-link to="/login" v-if="!isLoggedIn">   Login</router-link>
    <a href="#" v-if="isLoggedIn" @click="logout">Logout</a>
    <router-view/>
  </div>

</template>


<script>
import { mapActions, mapGetters} from 'vuex'

export default {
  name: "main",
  methods: {
    ...mapActions(["logout"])
  },
  computed: {
    ...mapGetters(["isLoggedIn"])
  }
};
</script>
<style>
.log{
  background-color: black;
}
</style>
