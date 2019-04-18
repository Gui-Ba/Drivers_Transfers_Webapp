<template>
  <v-navigation-drawer
  v-model="drawer"
  :mini-variant.sync="mini"
  hide-overlay
  stateless
  >
  <v-toolbar flat class="transparent">
    <v-list class="pa-0">
      <v-list-tile avatar>
        <v-list-tile-avatar>
          <img src="https://randomuser.me/api/portraits/men/85.jpg">
        </v-list-tile-avatar>

        <v-list-tile-content>
          <v-list-tile-title>Stan OO</v-list-tile-title>
        </v-list-tile-content>

        <v-list-tile-action>
          <v-btn
          icon
          @click.stop="mini = !mini"
          >
          <v-icon>chevron_left</v-icon>
        </v-btn>
      </v-list-tile-action>
    </v-list-tile>
  </v-list>
</v-toolbar>

<v-list class="pt-0" dense>
  <v-divider></v-divider>

  <v-list-tile
  v-for="item in items"
  :key="item.title"
  @click="user"
  >
  <v-list-tile-action>
    <v-icon>{{ item.icon }}</v-icon>
  </v-list-tile-action>

  <v-list-tile-content>
    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
  </v-list-tile-content>
</v-list-tile>
</v-list>
</v-navigation-drawer>
</template>

<script>
export default {
  data () {
    return {
      drawer: true,
      items: [
        { title: 'Propositions de transferts', icon: 'rv_hookup' },
        { title: 'Trajets realisés', icon: 'directions_car' },
        { title: 'Messages', icon: 'question_answer' },
        { title: 'Recommandations', icon: 'thumbs_up_down' },
        { title: 'Preferences', icon: 'settings' }
      ],
      mini: true,
      right: null
    }
  },
  methods: {
    user() {
    }
  }
}
</script>
