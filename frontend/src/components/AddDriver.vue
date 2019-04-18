<template>
  <div>
    <div class="list row">
      <div class="submitform">
        <div v-if="!submitted">
          <h4>Add driver</h4>
          <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" required v-model="driver.nom" name="nom">
          </div>

          <div class="form-group">
            <label for="prenom">Prenom</label>
            <input type="text" class="form-control" id="prenom" required v-model="driver.prenom" name="prenom">
          </div>

          <div class="form-group">
            <label for="age">Experience</label>
            <input type="number" class="form-control" id="age" required v-model="driver.age" name="age">
          </div>

          <div class="form-group">
            <label for="voiture">Voiture</label>
            <input type="text" class="form-control" id="voiture" required v-model="driver.voiture" name="voiture">
          </div>


          <button v-on:click="saveDriver" class="btn btn-success">Submit</button>
        </div>

        <div v-else>
          <h4>You submitted successfully!</h4>
          <button class="btn btn-success" v-on:click="newDriver">Add</button>
        </div>
      </div>
    </div>
    </div>
  </template>

  <script>
  import http from "../http-common";

  export default {
    name: "add-driver",
    data() {
      return {
        driver: {
          id: 0,
          name: "",
          prenom: "",
          voiture: "",
          age: 0,
          active: false
        },
        submitted: false
      };
    },
    methods: {
      /* eslint-disable no-console */
      saveDriver() {
        var data = {
          nom: this.driver.nom,
          prenom: this.driver.prenom,
          experience: this.driver.experience,
          voiture: this.driver.voiture,
        };

        http
        .post("/driver", data)
        .then(response => {
          this.driver.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

        this.submitted = true;
      },
      newDriver() {
        this.submitted = false;
        this.driver = {};
      }
      /* eslint-enable no-console */
    }
  };
  </script>

  <style>
  .submitform {
    max-width: 300px;
    margin: auto;
  }
  </style>
