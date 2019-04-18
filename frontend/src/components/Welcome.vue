<template>
  <div>
<snackbar></snackbar>
<snackbar_name></snackbar_name>
    <v-container fluid>
      <v-layout row>
        <v-flex
        grow
        pa-1
        >
        <v-card  >
          <v-card-text>
            <h4 class="display-1" >   Bienvenue   {{ $store.getters.nom }} sur la plateforme DRIVEREST!!
              <br>
              Nos services vous assurent les meilleurs transferts avec nos drivers! </h4>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>

    <v-layout align-center row>

      <v-img
      :src="photo.src"
      height="400px"
      max-width="400px"
      >
    </v-img>

  </v-layout>
</v-container>



</div>
</template>

<script>
import snackbar from "./snackbar_connect.vue";
import snackbar_name from "./snackbar_name.vue";

export default {
  components: {
    snackbar,
    snackbar_name
  },
  data() {
    return {
      photo:
      { src : 'https://regmedia.co.uk/2018/02/07/driver_shutterstock.jpg?x=442&y=293&crop=1' }

    }
  }
}
</script>

<style>
body
{
  padding: 30px;
  background-color: #fcfcfc;
}

.center-div {
  text-align: center;
  display: block;
  margin-left: auto;
  margin-right: auto;
  max-width: 400px;
  margin-top: 50px;
}


</style>
