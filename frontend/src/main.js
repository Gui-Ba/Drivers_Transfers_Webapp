import Vue from 'vue'
// import App from './App.vue'
import router from './router'
import Vuetify from 'vuetify'
import { store } from './store/store'
import Main from './Main.vue'

Vue.config.productionTip = false
Vue.use(Vuetify)

new Vue({
  router,
  store,
  // components: {
  //   "main": Main
  // },
  render: h => h(Main),
}).$mount('#app')
