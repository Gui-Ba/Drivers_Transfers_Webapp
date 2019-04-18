<template>
  <div v-if="this.driver">
    <h4>Driver</h4>
    <div>
      <label>Name: </label> {{this.driver.nom}}
    </div>
    <div>
      <label>Prenom: </label> {{this.driver.prenom}}
    </div>
    <div>
      <label>Experience: </label> {{this.driver.age}} ans
    </div>
    <div>
      <label>Voiture: </label> {{this.driver.voiture}}
    </div>
    <div>
      <label>Disponible: </label> {{this.driver.active}}
    </div>

    <span v-if="this.driver.active"
      v-on:click="updateActive(false)"
      class="button is-small btn-primary">Inactive</span>
    <span v-else
      v-on:click="updateActive(true)"
      class="button is-small btn-primary">Active</span>

    <span class="button is-small btn-danger" v-on:click="deleteDriver()">Delete</span>

  </div>
  <div v-else>
    <br/>
    <p>Please click on a Driver...</p>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "driver",
  props: ["driver"],
  methods: {
    /* eslint-disable no-console */
    updateActive(status) {
      var data = {
        id: this.driver.id,
        nom: this.driver.nom,
        prenom: this.driver.prenom,
        voiture: this.driver.voiture,
        age: this.driver.age,
        active: status
      };

      http
        .put("/driver/" + this.driver.id, data)
        .then(response => {
          this.driver.active = response.data.active;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteDriver() {
      http
        .delete("/Driver/" + this.driver.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push('/');
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>
