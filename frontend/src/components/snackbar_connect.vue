
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
    

      <!-- <v-btn
        color="pink"
        flat
        @click="snackbar = false"
      >
        Close
      </v-btn> -->
    </v-snackbar>
  </v-card>
</template>

<script>

export default {
  name: 'snackbar',
  data () {
    return {
      snackbar: true,
      y: 'top',
      x: null,
      mode: '',
      timeout: 3000,
      text: 'Vous êtes connecté'
    }
  },
  methods : {
    changed: function(event) {
      this.$store.commit('change', event.target.value)
    }
  }
}

</script>
