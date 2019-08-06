<template>
  <div class="p4summary">


    <lyra-grid
            formclass="ru.curs.demo.P4Summary"
            instanceid="grid10"
            :context="getInitContext()"
    >
    </lyra-grid>


  </div>
</template>

<script>

export default {

    components: {
        //lyraGrid: () => import('lyra-grid')
    },

    name: 'P4Summary',

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
  .summary-row {
    font-weight: bold;

    color: silver;
    background-color: blue;
  }
</style>
