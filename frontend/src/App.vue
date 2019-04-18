<template>
  <div>

    <v-toolbar
    color="cyan"
    dark
    tabs
    >
    <router-link tag="a" to="/">
      <a>
        <v-icon large color="red" >directions_car </v-icon>
        <v-spacer></v-spacer>
        <v-toolbar-title>    DRIVEREST
        </v-toolbar-title>
      </a>
    </router-link>
    <v-layout
    justify-center
    align-center
    >
    <v-toolbar-title align-center> TRANSFER WITH THE BEST DRIVERS
    </v-toolbar-title>
  </v-layout>

  <v-tooltip left>
    <v-btn slot="activator" icon>
      <v-icon>search</v-icon>
    </v-btn>
    <span>Search</span>
  </v-tooltip>

  <router-link to="/">
    <v-list-tile-avatar >
      <img src="https://randomuser.me/api/portraits/men/85.jpg">
    </v-list-tile-avatar>
  </router-link>

  <v-tooltip left>
    <v-btn slot="activator" icon flat @click="userSignOut()">
      <v-icon>exit_to_app</v-icon>
    </v-btn>
    <span>Exit</span>
  </v-tooltip>

  <v-tabs
  slot="extension"
  v-model="tab"
  color="cyan"
  grow
  >
  <!-- <v-tabs-slider color="yellow"></v-tabs-slider> -->

  <v-tab
  v-for="main_tab in main_tabs" :key="main_tab.name"  :to="{name: main_tab.name}" @click="submenu(main_tab.name)"  >
  {{main_tab.text}}
  <!-- <router-link to="{{tab.name}}"> {{tab.text}}</router-link> -->
</v-tab>
</v-tabs>
</v-toolbar>



<v-container fluid grid-list-md text-xs-center>
  <v-layout row >
    <router-link to="WelcomeDriver">
      <avatar_menu ></avatar_menu>
    </router-link>
    <v-layout  column  >
      <v-tabs :class="{menuHidden: menuDisplaydriver}" >
        <v-tab
        v-for="drivers_tab in drivers_tabs" :key="drivers_tab.name"  :to="{name: drivers_tab.name}">
        {{drivers_tab.text}}
      </v-tab>
    </v-tabs>
    <v-tabs :class="{menuHidden: menuDisplayclient}">
      <v-tab
      v-for="clients_tab in clients_tabs" :key="clients_tab.name"  :to="{name: clients_tab.name}">
      {{clients_tab.text}}
    </v-tab>
  </v-tabs>
  <v-tabs :class="{menuHidden: menuDisplaytransfer}">
    <v-tab
    v-for="transfers_tab in transfers_tabs" :key="transfers_tab.name"  :to="{name: transfers_tab.name}">
    {{transfers_tab.text}}
  </v-tab>
</v-tabs>
<v-tabs :class="{menuHidden: menuDisplaylocation}">
  <v-tab
  v-for="geolocation_tab in geolocation_tabs" :key="geolocation_tab.name"  :to="{name: geolocation_tab.name}">
  {{geolocation_tab.text}}
</v-tab>
</v-tabs>
<v-flex align-self: start>
  <router-view/>
</v-flex>
</v-layout>
</v-layout>
</v-container>



</div>


</template>

<script>
import Avatar_nav_drawer from "./components/Avatar_nav_drawer.vue"

export default {
  components: {
    'avatar_menu': Avatar_nav_drawer
  },
  name: "app",
  data: ()=> ({
    menuDisplaydriver : true,
    menuDisplayclient : true,
    menuDisplaytransfer : true,
    menuDisplaylocation : true,
    main_tabs: [
      { name: "dashboarddriver", text: "Drivers" },
      { name: "dashboardclient", text: "Clients" },
      { name: "transfers", text: "Transfers" },
      { name: "location", text: "Geolocation" },
    ]
    ,
    drivers_tabs:[
      { name: "driverslist", text: "List Drivers" },
      { name: "driverscarList", text: "Drivers with cars" },
      { name: "searchdriver", text: "Search Driver" },
      { name: "adddriver", text: "Add Driver" }
    ],
    clients_tabs:[
      { name: "clientslist", text: "List Clients" },
      { name: "searchclient", text: "Search Client" }
    ],
    transfers_tabs:[
      { name: "transferslist", text: "List transfers" },
      { name: "addtransfer", text: "Add Transfer" }
    ],
    geolocation_tabs:[
      { name: "dashboard_driver_front", text: "drivers front" },
      { name: "dashboard_driver_back", text: "driver back" }
    ]
  }),
  methods: {
    userSignOut () {
      this.$store.dispatch('userSignOut')
    },
    submenu(a) {
      if(a=="dashboarddriver"&&this.menuDisplaydriver==true)
      {this.menuDisplaydriver = !this.menuDisplaydriver;
        this.menuDisplayclient=true
        this.menuDisplaytransfer = true
        this.menuDisplaylocation =true}
        if(a=="dashboardclient"&&this.menuDisplayclient==true)
        {this.menuDisplayclient = !this.menuDisplayclient;
          this.menuDisplaytransfer = true
          this.menuDisplaylocation =true
          this.menuDisplaydriver=true}
          if(a=="transfers"&&this.menuDisplaytransfer==true)
          {this.menuDisplaytransfer = !this.menuDisplaytransfer;
            this.menuDisplaylocation =true
            this.menuDisplaydriver=true
            this.menuDisplayclient=true}
            if(a=="location"&&this.menuDisplaylocation==true)
            {this.menuDisplaylocation = !this.menuDisplaylocation;
              this.menuDisplaydriver=true
              this.menuDisplayclient=true
              this.menuDisplaytransfer = true}
            },
          }
        }
        </script>

        <style >
        @import "../node_modules/leaflet/dist/leaflet.css";
        .site-info {
          color: blue;
          margin-bottom: 20px;
        }

        .btn-primary {
          margin-right: 5px;
        }

        .container-fluid {
          text-align: center;
        }
        .menuHidden{
          display: none;
        }

        a{
          text-decoration: none;
          color:white;
        }

        </style>
