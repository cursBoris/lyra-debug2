<template>
  <div class="p2mainvue">


    <b-form-group
            label="Events" label-for="textarea">

      <b-form-textarea style="width:1350px;"
                       id="textarea" v-model="message" :rows="7" :max-rows="7">
      </b-form-textarea>

      <p></p>

      <b-form-textarea style="width:1350px;height:50px;"
                       id="context" v-model="context" :rows="3" :max-rows="3">
      </b-form-textarea>


      <b-button-toolbar>
        <b-button-group>
          <b-button v-on:click="clear">Clear events</b-button>
        </b-button-group>
        <p></p>
        <b-button-group>
          <b-button v-on:click="refresh1">Refresh grid1</b-button>
          <b-button v-on:click="refresh2">Refresh grid2</b-button>
          <b-button v-on:click="refresh3">Refresh grid3</b-button>
          <b-button v-on:click="refresh44">ALL Refresh grid1</b-button>
        </b-button-group>
        <p></p>
      </b-button-toolbar>


    </b-form-group>

    <p></p>


    <lyra-grid ref="lyraGrid1"

               formclass="ru.curs.demo.P2MainVue"
               instanceid="grid1"

               :context="getInitContext1()"

               v-on:select="select1"
               v-on:dblclick="dblclicked1"
               v-on:click="clicked1"

    >
    </lyra-grid>

    <p></p>

    <lyra-grid ref="lyraGrid2"

               formclass="ru.curs.demo.P2MainVue"
               instanceid="grid2"

               :context="getInitContext2()"

               v-on:select="select2"
               v-on:dblclick="dblclicked2"
               v-on:click="clicked2"

    >
    </lyra-grid>

    <p></p>


    <lyra-grid ref="lyraGrid3"

               formclass="ru.curs.demo.P2MainVue"
               instanceid="grid3"

               :context="getInitContext3()"

               v-on:select="select3"
               v-on:dblclick="dblclicked3"
               v-on:click="clicked3"

    >
    </lyra-grid>


  </div>
</template>

<script>

export default {

    components: {
        lyraGrid: () => import('lyra-grid')
    },

    name: 'P2MainVue',

    data() {
        return {
            message: '',
            context:
                '{' +
                '"part1": "part1",' +
                '"part2": "part2",' +

                '"refreshParams": {' +

                //74000004000079300
                //current
                '"selectKey": ["74000004000079300"],' +

                '"sort": ["name", "code"],' +
                //'"sort": "ocatd",'+

                '"filter": {' +
                '"filter1": "filter conditions 1",' +
                '"filter2": "filter conditions 2"' +
                '}' +

                '}' +
                '}',

        }
    },
    methods: {

        getInitContext1: function () {
            return {
                part1: "part1",
                part2: "part2",
                refreshParams:
                    {
                        //selectKey: "",
                        sort: ["gninmb", "code"],
                        filter: {
                            filter: "filter conditions",
                        }
                    }
            }
        },
        getInitContext2: function () {
            return {
                part1: "part1",
                part2: "part2",
                refreshParams:
                    {
                        //selectKey: "",
                        sort: ["code"],
                        filter: {
                            filter: "filter conditions",
                        }
                    }
            }
        },
        getInitContext3: function () {
            return {
                part1: "part1",
                part2: "part2",
                refreshParams:
                    {
                        //selectKey: "",
                        sort: ["name", "code"],
                        filter: {
                            filter: "filter conditions",
                        }
                    }
            }
        },


        refresh1: function () {
            this.$refs.lyraGrid1.$emit(
                'refresh',

                {
                    part1: "part1",
                    part2: "part2",
                    refreshParams:
                        {
                            //74000004000079300
                            //selectKey: "",
                            sort: ["name", "code"],
                            filter: {
                                filter: "filter conditions",
                            }
                        }
                }
            );
        },
        refresh2: function () {
            this.$refs.lyraGrid2.$emit(
                'refresh',

                {
                    part1: "part1",
                    part2: "part2",
                    refreshParams:
                        {
                            //74000004000079300
                            //selectKey: "",
                            //sort: "name,code",
                            sort: ["gninmb"],
                            filter: {
                                filter: "filter conditions",
                            }
                        }
                }
            );
        },
        refresh3: function () {
            this.$refs.lyraGrid3.$emit(
                'refresh',

                {
                    part1: "part1",
                    part2: "part2",
                    refreshParams:
                        {
                            //74000004000079300
                            //selectKey: "",
                            sort: ["name", "code"],
                            filter: {
                                filter: "filter conditions",
                            }
                        }
                }
            );
        },

        refresh44: function () {
            this.$refs.lyraGrid1.$emit('refresh', JSON.parse(this.context));
        },


        clear: function () {
            this.message = '';
        },

        select1: function (formClass, instanceId, obj) {
            console.log("select1");
            this.message = this.message + '\n' + "event:select1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        select2: function (formClass, instanceId, obj) {
            console.log("select2");
            this.message = this.message + '\n' + "event:select2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        select3: function (formClass, instanceId, obj) {
            console.log("select3");
            this.message = this.message + '\n' + "event:select3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

        clicked1: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        clicked2: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        clicked3: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

        dblclicked1: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        dblclicked2: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        dblclicked3: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

    }
}

</script>

