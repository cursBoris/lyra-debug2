var DojoWebpackPlugin = require("dojo-webpack-plugin");
var CopyWebpackPlugin = require("copy-webpack-plugin");

module.exports = {
    devServer: {
        proxy: {
            '/lyra': {
                target: 'http://localhost:8088',
                ws: true,
                changeOrigin: false
            }
        },

        port: 8081
    },

    outputDir: 'target/dist',
    assetsDir: 'static',

    configureWebpack: {
        plugins: [
            new DojoWebpackPlugin({
                loaderConfig: require("./node_modules/lyra-grid/config/loaderConfig"),
                environment: {dojoRoot: "."},	// used at run time for non-packed resources (e.g. blank.gif)
                buildEnvironment: {dojoRoot: "node_modules"}, // used at build time
                locales: ["en", "ru"],
                //noConsole: true
            }),
            new CopyWebpackPlugin({
                patterns: [
                    {
                        context: "node_modules",
                        from: "dojo/resources/blank.gif",
                        to: "dojo/resources"
                    }
                ]
            }),
        ],

        optimization: {
            splitChunks: false
        },

    }
}
