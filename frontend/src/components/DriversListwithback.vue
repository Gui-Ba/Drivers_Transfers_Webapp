<template>



    <div class="list row">
        <div class="col-md-6">
            <h4>Liste Drivers</h4>
            <ul>
                <li v-for="(driver, index) in drivers" :key="index">
                    <router-link :to="{
                            name: 'driver-details',
                            params: { driver: driver, id: driver.id }
                        }">
                          {{driver.id}} : {{driver.nom}} {{driver.prenom}}

                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "drivers-list",
  data() {
    return {
      drivers: [ ]
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveDrivers() {
      http
        .get("/drivers")
        .then(response => {
          this.drivers = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveDrivers();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveDrivers();
  }
};

</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
