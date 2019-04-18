<template>
  <div>

    <v-dialog v-model="dialog" max-width="500px" >
      <v-btn slot="activator" color="primary" dark class="mb-2">New Car Driver</v-btn>
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


    <v-card>
      <v-container   fluid   grid-list-md  >
        <v-layout row wrap>
          <v-flex
          v-for="driver in drivers"
          :key="driver.nom"
          v-bind="{ [`xs${driver.flex}`]: true }"
          >
          <v-card>
            <v-img
            :src="driver.src"
            height="200px"
            >
            <v-container
            fill-height
            fluid
            pa-2
            >
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline white--text" >Disponible</span>

              </v-flex>
            </v-layout>
          </v-container>
        </v-img>

        <v-card-actions>
          <span class="headline white--text" v-text="driver.nom"></span>
          <v-spacer></v-spacer>
          <span class="headline white--text" v-text="driver.prenom"></span>
          <v-spacer></v-spacer>
          <v-btn icon>
            <v-icon
            small
            class="mr-2"
            @click="editItem(driver)">
            edit
          </v-icon>
        </v-btn>
        <v-btn icon>
          <v-icon small @click="deleteItem(driver)" >
            delete
          </v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-flex>
</v-layout>
</v-container>
</v-card>




</div>
</template>

<script>
export default {
  name: "drivers-list",
  data: ()=> ({
    dialog: false,

    driverss:  [
      {
        nom: 'aaa',
        prenom: 'aaa',
        age: 3,
        voiture : 'fiat',
        flex:3,
        src : 'https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/gallardo-0638.jpg?itok=-So1NoXA'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'https://avisassets.abgemea.com/.imaging/featureImageLarge/dms/DMS/local/ZA/fleet/rent-a-car/group-a-kia-picanto.jpg'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'http://www.americancarcity.fr/img/stock/Ford/Ford-Mustang-Shelby-GTE-2017-1208-1.jpg'
      }
    ],

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
),

computed: {
  formTitle () {
    return this.editedIndex === -1 ? 'New Car Driver' : 'Edit Driver'
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
        voiture : 'fiat',
        flex:3,
        src : 'https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/gallardo-0638.jpg?itok=-So1NoXA'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'https://avisassets.abgemea.com/.imaging/featureImageLarge/dms/DMS/local/ZA/fleet/rent-a-car/group-a-kia-picanto.jpg'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'http://www.americancarcity.fr/img/stock/Ford/Ford-Mustang-Shelby-GTE-2017-1208-1.jpg'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'https://avisassets.abgemea.com/.imaging/featureImageLarge/dms/DMS/local/ZA/fleet/rent-a-car/group-a-kia-picanto.jpg'
      },
      {
        nom: 'aaabb',
        prenom: 'aaabb',
        age: 30,
        voiture : 'fiat',
        flex:3,
        src : 'http://www.americancarcity.fr/img/stock/Ford/Ford-Mustang-Shelby-GTE-2017-1208-1.jpg'
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
