
import Vue from "vue";
import Router from "vue-router";
import WelcomeDriver from "./components/WelcomeDriver.vue";
import Avatar_nav_drawer from "./components/Avatar_nav_drawer.vue"
import DriversList from "./components/DriversList.vue";
import ClientsList from "./components/ClientsList.vue";
import DriverscarList from "./components/DriverscarList.vue";
import AddDriver from "./components/AddDriver.vue";
import AddTransfer from "./components/AddTransfer.vue";
import SearchDrivers from "./components/SearchDrivers.vue";
import Driver from "./components/Driver.vue";
import Geolocation_front from "./components/Geolocation_front.vue";
import Geolocation_back from "./components/Geolocation_back.vue";
import SearchTransfer from "./components/SearchTransfer.vue";
import Dashboarddriver from "./components/Dashboarddriver.vue";
import Dashboardclient from "./components/Dashboardclient.vue"
import Welcome from "./components/Welcome.vue";
import Login from "./components/Login.vue";
import App from "./App.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: '/login',
      name: "Login",
      component: Login
    },
    {
      path: '/App',
      name: "App",
      component: App,

      children: [
        {
          path: "/WelcomeDriver",
          name: "WelcomeDriver",
          component: WelcomeDriver
        },
        {
          path: "/dashboarddriver",
          name: "dashboarddriver",
          component: Dashboarddriver
        }
      ]
    },
    {
      path: "/",
      // path: "/Welcome",
      name: "Welcome",
      component: Welcome
    },
    // {
    //   path: "/WelcomeDriver",
    //   name: "WelcomeDriver",
    //   component: WelcomeDriver
    // },
    // {
    //   path: "/dashboarddriver",
    //   name: "dashboarddriver",
    //   component: Dashboarddriver
    // },
    {
      path: "/dashboardclient",
      name: "dashboardclient",
      component: Dashboardclient
    },
    {
      path: "/avatar",
      name: "Avatar",
      component: Avatar_nav_drawer
    },
    {
      path: "/drivers/driverslist",
      name: "driverslist",
      component: DriversList,
      children: [
        {
          path: "/driver/:id",
          name: "driver-details",
          component: Driver,
          props: true
        }
      ]
    },
    {
      path: "/drivers/driverscarlist",
      name: "driverscarList",
      component: DriverscarList
    },
    {
      path: "/clients/clientslist",
      name: "clientslist",
      component: ClientsList
    },
    {
      path: "/adddriver",
      name: "adddriver",
      component: AddDriver
    },
    {
      path: "/addT",
      name: "addT",
      component: AddTransfer
    },

    {
      path: "/search",
      name: "searchdriver",
      component: SearchDrivers
    },
    {
      path: "/searchtransfer",
      name: "searchdtransfer",
      component: SearchTransfer
    },
    {
      path: "/geolocation_front",
      name: "dashboard_driver_front",
      component: Geolocation_front
    },
    {
      path: "/geolocation_front",
      name: "location",
      component: Geolocation_front
    },
    {
      path: "/geolocation_back",
      name: "dashboard_driver_back",
      component: Geolocation_back
    }
  ]
});
