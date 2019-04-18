<template>
  <div>

    <v-dialog v-model="dialog" max-width="500px" >
      <v-btn slot="activator" color="primary" dark class="mb-2">New Driver</v-btn>
      <v-card   >
        <v-card-title>
          <span class="headline">{{ formTitle }}</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="editedItem.nom" label="Nom"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="editedItem.prenom" label="Prenom"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="editedItem.age" label="Experience"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="editedItem.voiture" label="Voiture"></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Cancel</v-btn>
          <v-btn color="blue darken-1" flat @click="save">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>


    <v-data-table
    :headers="headers"
    :items="drivers"
    class="elevation-1"
    >
    <template slot="items" slot-scope="props">
      <td>{{ props.item.nom }}</td>
      <td class="text-xs-right">{{ props.item.prenom }}</td>
      <td class="text-xs-right">{{ props.item.age }}</td>
      <td class="text-xs-right">{{ props.item.voiture }}</td>
      <td class="justify-center layout px-0">
        <v-icon
        small
        class="mr-2"
        @click="editItem(props.item)"
        >
        edit
      </v-icon>
      <v-icon
      small
      @click="deleteItem(props.item)"
      >
      delete
    </v-icon>
  </td>
</template>
<template slot="no-data">
  <v-btn color="primary" @click="initialize">Reset</v-btn>
</template>
</v-data-table>
</div>
</template>

<script>
export default {
  name: "drivers-list",
  data() {
    return {
      dialog: false,
      headers: [
        {
          text: 'Nom',
          align: 'left',
          value: 'nom',
        },
        { text: 'Prénom', value: 'prenom' },
        { text: 'Expérience', value: 'age' },
        { text: 'Voiture', value: 'voiture' },
        { text: 'Actions', value: 'name', sortable: false }
      ],
      drivers: [],

      editedIndex: -1,
      editedItem: {
        nom: '',
        prenom: 0,
        age: 0,
        voiture: 0
      },
      defaultItem: {
        nom: '',
        prenom: 0,
        age: 0,
        voiture: 0
      }
    }
  },

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'New Driver' : 'Edit Driver'
    }
  },

  watch: {
    dialog (val) {
      val || this.close()
    }
  },

  created () {
    this.initialize()
  },


  methods:{


    initialize () {
      this.drivers = [
        {
          nom: 'aaa',
          prenom: 'aaa',
          age: 3,
          voiture : 'fiat'
        },
        {
          nom: 'aaabb',
          prenom: 'aaabb',
          age: 30,
          voiture : 'fiat'
        },
        {
          nom: 'aaabb',
          prenom: 'aaabb',
          age: 30,
          voiture : 'fiat'
        }
      ]
    },

    editItem (item) {
      this.editedIndex = this.drivers.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem (item) {
      const index = this.drivers.indexOf(item)
      confirm('Are you sure you want to delete this driver?') && this.drivers.splice(index, 1)
    },


    close () {
      this.dialog = false
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      }, 300)
    },

    save () {
      if (this.editedIndex > -1) {
        Object.assign(this.drivers[this.editedIndex], this.editedItem)
      } else {
        this.drivers.push(this.editedItem)
      }
      this.close()
    }
  }


}
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
