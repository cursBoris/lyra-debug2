<template>
  <div class="p8cssrow">


    <lyra-grid
            formclass="ru.curs.demo.P8CssRow"
            instanceid="grid6"
            :context="getInitContext()"
    >
    </lyra-grid>


  </div>
</template>

<script>

export default {

    components: {
        lyraGrid: () => import('lyra-grid')
    },

    name: 'P8CssRow',

    data() {
        return {}
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

    }
}

</script>


<style>
  .jslivegrid-record-bold {
    overflow: auto;
    background-color: #87cefa;
    font-weight: bold;
  }

  .jslivegrid-record-italic {
    font-style: italic;
  }


  /*
    .fc-color-white {
      background-color: white;
      border-right-style: solid !important;
      border-left-style: solid !important;
    }

    .fc-color-red {
      background-color: red;
    }
  */

</style>
