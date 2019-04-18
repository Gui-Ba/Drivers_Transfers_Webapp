<template>
  <div >
    <v-container fluid>
      <v-layout row>
        <v-flex
        grow
        pa-1
        >
        <v-card >
          <v-card-text>

            <h4>  {{user.prenom}} {{user.nom}}, bienvenue dans votre espace driver ! </h4>


          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row>
      <v-flex
      grow
      pa-1
      >


      <v-card >
        <v-badge color="red">
          <span slot="badge">3</span>
          <v-icon
          large
          color="red"
          >
          directions_car
        </v-icon>
      </v-badge>

      <v-card-text>
        <h4> vous avez 2 demandes de trajet! </h4>
      </v-card-text>
    </v-card>
  </v-flex>
  <v-flex
  grow
  pa-1
  >
  <v-card >

    <v-badge color="red">
      <span slot="badge">3</span>
      <v-icon
      large
      color="red"
      >
      mail
    </v-icon>
  </v-badge>

  <v-card-text>
    <h4> vous avez 4 messages </h4>
  </v-card-text>
</v-card>
</v-flex>
</v-layout>
</v-container>



<div class="center-div">

  <v-img
  :src="photo.src"
  height="200px"
  >
</v-img>

</div>
</div>
</template>

<script>
export default {
  data() {
    return {
      // nom: 'michel',
      user:
      { nom: 'OO', prenom: 'Stan' }
      ,
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
