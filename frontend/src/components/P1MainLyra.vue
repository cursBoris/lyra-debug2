<template>
  <div class="p1mainlyra">


    <b-form-textarea style="width:1350px;height:50px;"
                     id="context" v-model="context2" :rows="3" :max-rows="3">
    </b-form-textarea>


    <b-button-toolbar>
      <b-button-group>
        <b-button v-on:click="refresh442">ALL Refresh grid</b-button>
      </b-button-group>
    </b-button-toolbar>


    <lyra-grid ref="lyraGrid1"

               formclass="ru.curs.demo.P1MainLyra"
               instanceid="grid1"
               :context="getInitContext()"

    >
    </lyra-grid>
    <!--
                  :context="getInitContext()"
    -->

  </div>
</template>

<script>


export default {

    name: 'P1MainLyra',

    components: {
        lyraGrid: () => import('lyra-grid')
    },

    data() {
        return {
            context2:
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

        getInitContext: function () {
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

        refresh442: function () {
            this.$refs.lyraGrid1.$emit('refresh', JSON.parse(this.context2));
        },
    }
}

</script>

