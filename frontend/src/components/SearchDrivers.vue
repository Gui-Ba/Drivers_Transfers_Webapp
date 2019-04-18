<template>
  <div>

    <div class="list row">
      <div class="searchform">

        <h4>Find driver by Experience</h4>
        <div class="form-group">
          <input type="number" class="form-control" id="age" required v-model="age" name="voiture">
        </div>
        <div class="btn-group">
          <button v-on:click="searchDriversbyAge" class="btn btn-success">Search</button>
        </div>

        <h4>Find driver by Voiture</h4>
        <div class="form-group">
          <input type="string" class="form-control" id="voiture" required v-model="voiture" name="voiture">
        </div>
        <div class="btn-group">
          <button v-on:click="searchDriversbyCar" class="btn btn-success">Search</button>
        </div>
      </div>


      <ul class="search-result">
        <li v-for="(driver, index) in drivers" :key="index">
          <h6>{{driver.nom}} {{driver.age}} {{driver.voiture}}</h6>
        </li>
      </ul>




    </div>
  </div>

</template>

<script>
import http from "../http-common";

export default {
  name: "search-drivers",
  data() {
    return {
      age:"",
      voiture: "",
      drivers: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    searchDriversbyCar() {
      http
      .get("/drivers/voiture/" + this.voiture)
      .then(response => {
        this.drivers = response.data; // JSON are parsed automatically.
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
    },
    searchDriversbyAge() {
      http
      .get("/drivers/age/" + this.age)
      .then(response => {
        this.drivers = response.data; // JSON are parsed automatically.
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
    }

    /* eslint-enable no-console */
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>
