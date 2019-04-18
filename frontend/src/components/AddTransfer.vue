<template>

  <div>
    <v-toolbar flat color="white">
      <v-toolbar-title>Add Transfer</v-toolbar-title>
      <v-divider        class="mx-2"     inset     vertical
      ></v-divider>
      <v-spacer></v-spacer>
    </v-toolbar>

  <div class="submitform">
    <div v-if="!submitted">
        <div class="form-group">
          <label for="nom">Nom</label>
          <input type="text" class="form-control" id="nom" required v-model="transfer.nom" name="nom">
        </div>

        <div class="form-group">
          <label for="prenom">Prenom</label>
          <input type="text" class="form-control" id="prenom" required v-model="transfer.prenom" name="prenom">
        </div>

        <div class="form-group">
          <label for="distance">Distance</label>
          <input type="number" class="form-control" id="distance" required v-model="transfer.distance" name="distance">
        </div>

        <div class="form-group">
          <label for="prix">Prix</label>
          <input type="number" class="form-control" id="prix" required v-model="transfer.distance" name="prix">
        </div>

        <div class="form-group">
          <label for="date">Date</label>
          <input type="date" class="form-control" id="date" required v-model="transfer.date" name="date">
        </div>


        <button v-on:click="savetransfer" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" v-on:click="newtransfer">Add</button>
    </div>
  </div>
</div>

</template>

<script>
import http from "../http-common";

export default {
  name: "add-transfer",
  data() {
    return {
      transfer: {
        id: 0,
        name: "",
        prenom: "",
        distance: "",
        prix: 0,
        date: 0,
        active: false
      },
      submitted: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    savetransfer() {
      var data = {
        nom: this.transfer.nom,
        prenom: this.transfer.prenom,
        distance: this.transfer.distance,
        prix: this.transfer.prix,
        date: this.transfer.date,
      };

      http
        .post("/transfer", data)
        .then(response => {
          this.transfer.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    newtransfer() {
      this.submitted = false;
      this.transfer = {};
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
