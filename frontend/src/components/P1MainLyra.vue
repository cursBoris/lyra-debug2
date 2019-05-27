<template>
  <div class="p1mainlyra">


    <b-form-textarea style="width:1150px;height:50px;"
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


  </div>
</template>

<script>

export default {

    components: {
        lyraGrid: () => import('lyra-grid/LyraGrid')
    },

    name: 'P1MainLyra',

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
                '"sort": "name,code",' +
                //'"sort": "ocatd",'+
                '"filter": "filter conditions"' +
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
                        sort: "name,code",
                        filter: "filter conditions"
                    }
            }
        },

        refresh442: function () {
            this.$refs.lyraGrid1.$emit('refresh', JSON.parse(this.context2));
        },
    }
}

</script>

