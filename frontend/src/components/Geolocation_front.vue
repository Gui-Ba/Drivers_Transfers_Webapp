<template>

  <div>
    <v-container grid-list-md  fluid>
      <h3> DRIVER GEOLOCATION DASHBOARD </h3>

      <v-layout row wrap >
        <v-flex  md3>
          <!-- <div style="width: 30%; overflow: auto;"> -->

          <!-- <h5>TRANSFERT LYON -> PARIS </h5>
          <label>DRIVER {{locationdrivers[1].name}} DISTANCE PARCOURUE</label>
          <div>
          <input type="range" v-model="locationdrivers[1].value" min="0" max="100">
          <span>{{locationdrivers[1].value}}%</span>
          <div>
          LOCATION GPS Driver D2
          <span>{{locationdrivers[1].lng}} - {{locationdrivers[1].lat}}</span>
          <span v-text="updatepoint"></span>
        </div>
      </div>
    </div> -->
    <div>
      <h5>DRIVER {{locationdrivers[2].name}} : TRANSFERT BORDEAUX -> PARIS </h5>
      <div> DISTANCE TRANSFERT : {{locationdrivers[2].dt}} km
      </div>

      <label> SPEED</label>
      <input type="range" v-model="locationdrivers[2].speed" min="0" max="230">
      <span>{{locationdrivers[2].speed}} km/h</span>

      <div> TEMPS TRANSFERT : {{locationdrivers[2].tth}} heures {{locationdrivers[2].ttm}} minutes </div>

      <br/>
      <div> REALTIME
        <div class="list row">
          <div class="col-md-3">
            <div> DISTANCE
              <input type="range" v-model="locationdrivers[2].dist" min="0" max="1000">
              <span>{{locationdrivers[2].dist}} km</span>
            </div>
          </div>
          <div class="col-md-3">
            <div> TEMPS
              <input type="range" v-model="locationdrivers[2].tsecondes" min="0" max="40000">
              <span>{{locationdrivers[2].h}} h {{locationdrivers[2].min}} min</span>
            </div>
          </div>
        </div>
        <div>
          LOCATION GPS
          <span>{{locationdrivers[2].lng}}    {{locationdrivers[2].lat}}</span>
        </div>
        <button v-on:click="reset(2)">RESET</button>
        <span v-text="updatepoint"></span>
        <span v-text="updatepointspeed"></span>
        <span v-text="updatetimespeed"></span>
        <span v-text="updatetimedriver"></span>
        <span v-text="updatetimetransfer"></span>
      </div>
    </div>


  </v-flex>
  <v-flex
  md8
  >

  <l-map
  ref="map"
  :zoom="zoom"
  :center="center"
  :options="mapOptions"
  style="height: 600px"
  @update:center="centerUpdate"
  >
  <l-tile-layer
  :url="url"
  :attribution="attribution"
  />
  <l-marker
  v-for=" locationdriver in  locationdrivers"
  :lat-lng="locationdriver"
  :key="locationdriver.name">
  <l-tooltip :options="{permanent: true, interactive: true}" :content="locationdriver.name"/>
</l-marker>
</l-map>

</v-flex>
</v-layout>
</v-container>

</div>
</template>

<script>

import { LMap, LTileLayer, LMarker, LTooltip, LPopup } from 'vue2-leaflet';

export default {
  name:"dashboard",
  components: {
    LMap,
    LTileLayer,
    LMarker,
    LPopup,
    LTooltip
  },
  data () {
    return {
      drivers :[
        { name: 'D1'},
        { name: 'D2' },
        { name: 'D3' },
        { name: 'D4' }
      ],
      locationdrivers : [
        { name: 'D1', value:100, speed:100, lng: 0, lat: 0 },
        { name: 'D2', value:0, speed:100, lng: 0, lat: 0 },
        { name: 'D3', value:100, speed:100, dt:0 , tttsecondes:0 , tth:0 ,ttm:0 ,lng: 0, lat: 0,  tsecondes:0, dist:0, h: 0 , min:0 },
        { name: 'D4', value:100, speed:100, dt:0 , tttsecondes:0 , tth:0 ,ttm:0 ,lng: 0, lat: 0,  tsecondes:0, dist:0, h: 0 , min:0 },
      ],
      startdrivers: [
        { name: 'D1', lng: 7.75, lat: 48.5833 },
        { name: 'D2', lng: 4.85, lat:  45.75 },
        { name: 'D3', lng: -0.5667, lat: 44.8333 },
        { name: 'D4', lng: 7.2661, lat: 43.7031 }
      ],
      finishdrivers: [
        { name: 'D1', lng: 2.3488, lat: 48.8534 },
        { name: 'D2', lng: 2.3488, lat: 48.8534 },
        { name: 'D3', lng: 2.3488, lat: 48.8534 },
        { name: 'D4', lng:  2.3488, lat: 48.8534 }
      ],

      zoom: 6,
      center: L.latLng(47.902964, 1.909251),
      url: 'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      currentZoom: 11.5,
      currentCenter: [7.2661, 43.7031],
      showParagraph: false,
      mapOptions: {
        zoomSnap: 0.5
      },
      selected: 'D1',
      timecreate: null,
      timestart: null,
      timeFromNow : null

    };
  },
  // mounted () {
  //   this.$refs.map.mapObject.setView([70, 120], 6);
  // },
  // created: function () {
  //   // `this` est une référence à l'instance de vm
  //   console.log(this.drivers[0].lat)
  // },

  methods: {
    centerUpdate (center) {
      this.currentCenter = center;
    },
    console: function (a) {
      window.console.log(this.$data.locationdrivers[a].lat)
      window.console.log(this.$data.locationdrivers[a].lng)
    },
    callFunction: function () {
      setTimeout(() => {
        // this.message = "HELLO CLIENT!";
        this.change();
        this.$data.locationdrivers[0].lat=48.8534;
        // window.console.log(this.$data.locationdrivers[0].lat);
      }, 5000);
    },
    change: function(){
      this.$data.locationdrivers[0].lat=48.8534;
      this.$data.locationdrivers[0].lng=2.3488;
      // window.console.log(this.$data.Ddrivers[0].lat);
    },
    calculmove: function(dx,x1, y1, x2, y2){
      var a={x: x2-x1, y:y2-y1};
      return {x: x1+a.x*dx/100, y: y1+a.y*dx/100}
    },
    calculmove1: function(dx,x1, y1, x2, y2){
      var a={x: x2-x1, y:y2-y1};
      var b = this.distance(y1, x1, y2, x2)/1000
      return {x: x1+a.x*dx/b, y: y1+a.y*dx/b}
    },
    calculdistancespeedtime: function(i){
      var t=this.$data.locationdrivers[i].tsecondes
      var v=this.$data.locationdrivers[i].speed
      var d=t*v/3600
      // window.console.log(d);
      this.$data.locationdrivers[i].dist=Math.round(d)
      return  d
    },
    calcultimedistanceespeed: function(i){
      var v=this.$data.locationdrivers[i].speed
      var d=this.$data.locationdrivers[i].dist
      var t=d/v*3600
      // window.console.log(t);
      this.$data.locationdrivers[i].tsecondes=Math.round(t)
    },

    convertRad: function(input){
      return (Math.PI * input)/180;
    },
    distance: function (lat_a_degre, lon_a_degre, lat_b_degre, lon_b_degre){

      var  R = 6378000 //Rayon de la terre en mètre

      var lat_a = this.convertRad(lat_a_degre);
      var lon_a = this.convertRad(lon_a_degre);
      var lat_b = this.convertRad(lat_b_degre);
      var lon_b = this.convertRad(lon_b_degre);

      var d = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)))
      return d;
    },
    newpoint: function(i){
      var dx=  this.$data.locationdrivers[i].value
      var x1=  this.$data.startdrivers[i].lng
      var y1= this.$data.startdrivers[i].lat
      var x2=  this.$data.finishdrivers[i].lng
      var y2= this.$data.finishdrivers[i].lat
      var point=this.calculmove(dx,x1, y1, x2, y2 )
      // window.console.log(point.x , point.y);
      this.$data.locationdrivers[i].lat=this.round(point.y)
      this.$data.locationdrivers[i].lng=this.round(point.x)
    },
    newpointspeedtime: function(i){
      var  dx=this.calculdistancespeedtime(i)
      var x1=  this.$data.startdrivers[i].lng
      var y1= this.$data.startdrivers[i].lat
      var x2=  this.$data.finishdrivers[i].lng
      var y2= this.$data.finishdrivers[i].lat
      var d = this.distance(y1, x1, y2, x2)/1000
      var v=this.$data.locationdrivers[i].speed
      var tt= d*3600/v
      var point=this.calculmove1(dx,x1, y1, x2, y2 )
      // window.console.log(point.x , point.y);
      this.$data.locationdrivers[i].tttsecondes=Math.round(tt)
      this.$data.locationdrivers[i].dt=this.round(d)
      this.$data.locationdrivers[i].lat=this.round(point.y)
      this.$data.locationdrivers[i].lng=this.round(point.x)

    },
    round: function(x) {
      return Number.parseFloat(x).toPrecision(3);
    },

    initlocation: function(){
      for (var i=0; i<4;i++ ){
        this.$data.locationdrivers[i].lat= this.$data.startdrivers[i].lat;
        this.$data.locationdrivers[i].lng= this.$data.startdrivers[i].lng;
      }
    },
    reset: function(a) {
      // alert('Reinitialisation du model')
      this.$data.locationdrivers[a].tsecondes=0
      this.$data.locationdrivers[a].speed=100
      this.initlocation()
    },

    // time: function(){
    //   var timerStart = Date.now();
    //   window.console.log(timerStart);
    //   this.$data.timestart=timerStart;
    // },

    // getTimeFromNow () {
    //   this.timeFromNow = moment(this.created).fromNow()
    // },

    realtimedriver: function(i){
      // tmp en secondes
      var tmp =this.$data.locationdrivers[i].tsecondes;
      // window.console.log(tmp)
      var sec = tmp % 60;
      tmp = Math.floor((tmp-sec)/60);
      var min = tmp % 60;
      this.$data.locationdrivers[2].min=min;
      tmp = Math.floor((tmp-min)/60);
      var hour = tmp % 24;
      this.$data.locationdrivers[2].h=hour;
      // tmp = Math.floor((tmp-hour)/24);
    },
    timetransfer: function(i){
      // tmp en secondes
      var tmp =this.$data.locationdrivers[i].tttsecondes;
      // window.console.log(tmp)
      var sec = tmp % 60;
      tmp = Math.floor((tmp-sec)/60);
      var min = tmp % 60;
      this.$data.locationdrivers[2].ttm=min;
      tmp = Math.floor((tmp-min)/60);
      var hour = tmp % 24;
      this.$data.locationdrivers[2].tth=hour;
      // tmp = Math.floor((tmp-hour)/24);
    }
  },
  mounted () {
    this.initlocation()
    this.callFunction()
  },
  // created () {
  //   this.getTimeFromNow()
  //   setInterval(this.getTimeFromNow, 1000)
  // },
  // destroyed () {
  //   clearInterval(this.getTimeFromNow)
  // },
  computed: {
    updatepoint: function (){
      return this.newpoint(1)
    },
    updatepointspeed: function (){
      return this.newpointspeedtime(2)
    },
    updatetimespeed: function (){
      return this.calcultimedistanceespeed(2)
    },
    updatetimedriver: function (){
      return this.realtimedriver(2)
    },
    updatetimetransfer: function (){
      return this.timetransfer(2)
    },

  }
}
</script>
