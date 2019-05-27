<template>
  <div class="p6showcasetypes">


    <lyra-grid
            formclass="ru.curs.demo.P6ShowcaseTypes"
            instanceid="grid5"
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

    name: 'P6ShowcaseTypes',

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
                        sort: "code",
                        filter: "filter conditions"
                    }
            }
        },

    }
}

</script>


<style>
  .websitesvue-code {
    font-size: 1em;
    white-space: nowrap;
    width: 50px;
    text-align: right;
    vertical-align: middle;
  }

  .websitesvue-name {
    font-size: 2em;
    white-space: nowrap;
    width: 150px;
    text-align: center;
    vertical-align: middle;
    /*
    color: blueviolet;
    background-color: cadetblue;
    */
    font-style: italic;
    font-weight: bold;
  }

  .websitesvue-picture {
    font-size: 1em;
    white-space: nowrap;
    width: 150px;
    text-align: center;
    vertical-align: middle;
  }

  .websitesvue-file1 {
    font-size: 1em;
    white-space: nowrap;
    width: 150px;
    text-align: left;
    vertical-align: middle;
  }

  .websitesvue-logo {
    font-size: 1em;
    white-space: nowrap;
    width: 150px;
    text-align: center;
    vertical-align: middle;
  }

  .websitesvue-file2 {
    font-size: 1em;
    white-space: nowrap;
    width: 150px;
    text-align: center;
    vertical-align: middle;
  }

  .websitesvue-url {
    font-size: 1em;
    white-space: nowrap;
    width: 150px;
    text-align: center;
    vertical-align: middle;
  }
</style>
