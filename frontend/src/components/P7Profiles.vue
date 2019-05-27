<template>
  <div class="p7profiles">


    <lyra-grid
            formclass="ru.curs.demo.P7Profiles"
            instanceid="grid7"
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

    name: 'P7Profiles',

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
                        sort: "name,code",
                        filter: "filter conditions"
                    }
            }
        },

    }
}

</script>

