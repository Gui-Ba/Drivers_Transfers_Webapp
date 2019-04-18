
<template>
  <v-card>
    <!-- <v-card-text>

      <v-btn
        block
        color="primary"
        dark
        @click="snackbar = true"
      >
        Show Snackbar
      </v-btn>
    </v-card-text> -->

    <v-snackbar
      v-model="snackbar"
      :timeout="timeout"
      :top="y === 'top'"

    >
      {{ text }}
    <br>
      <div>
        <label for="nom"></label>
        <input @input="changed" name="nom" v-on:keyup.enter="snackbar = false">

      </div>

      <v-btn
        color="pink"
        flat
        @click="snackbar = false"
      >
        Close
      </v-btn>
    </v-snackbar>
  </v-card>
</template>

<script>

export default {
  name: 'snackbarname',
  data () {
    return {
      snackbar: true,
      y: 'center',
      x: null,
      mode: '',
      timeout: 20000,
      text: 'Quel est votre prénom?'
    }
  },
  methods : {
    changed: function(event) {
      this.$store.commit('change', event.target.value)
    }
  }
}

</script>
