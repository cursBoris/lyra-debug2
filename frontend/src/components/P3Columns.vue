<template>
  <div class="p3columns">


    <b-form-group
            label="Events" label-for="textarea">

      <b-form-textarea style="width:1150px;height:300px;"
                       id="textarea" v-model="message2" :rows="20" :max-rows="20">
      </b-form-textarea>

      <p></p>

      <b-button-toolbar>
        <b-button-group>
          <b-button v-on:click="clear2">Clear events</b-button>
        </b-button-group>
        <p></p>
        <p></p>
        <b-button-group>
          <b-button v-on:click="hideColumns">hideColumns code, socr</b-button>
          <b-button v-on:click="showColumns">showColumns code, socr</b-button>
        </b-button-group>
        <p></p>
      </b-button-toolbar>

    </b-form-group>

    <lyra-grid ref="lyraGrid9"
               formclass="ru.curs.demo.P3Columns"
               instanceid="grid9"

               :context="getInitContext()"

               v-on:columns-info="columnsInfo"

    >
    </lyra-grid>

  </div>
</template>

<script>

export default {

    components: {
        lyraGrid: () => import('lyra-grid')
    },

    name: 'P3Columns',

    data() {
        return {
            message2: '',
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

        hideColumns: function () {
            var arr = [{id: "code", visible: false}, {id: "socr", visible: false}];
            this.$refs.lyraGrid9.$emit('set-columns-visibility', arr);
        },
        showColumns: function () {
            var arr = [{id: "code", visible: true}, {id: "socr", visible: true}];
            this.$refs.lyraGrid9.$emit('set-columns-visibility', arr);
        },

        columnsInfo: function (formClass, instanceId, obj) {
            this.message2 = this.message2 + '\n' + "event:columns-info" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        clear2: function () {
            this.message2 = '';
        },
    }
}

</script>

