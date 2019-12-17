var path = require('path');
var HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
    entry : './app/index.js',
    output : {
        path: path.resolve(__dirname , 'dist'),
        filename : 'bundle.js'
    },
    resolve:{
        modules:[__dirname, 'src', 'node_modules'],
        extensions: ['*', '.js', '.jsx', '.tsx', '.ts']
    },
    devServer:{
        contentBase: path.join(__dirname, 'dist'),
        compress: true,
        port: 3030
    },
    module: {
        rules:[
            {test : /\.(js)$/, use:'babel-loader'},
            {test: /\.css$/, use :['style-loader', 'css-loader']}
        ]
    },
    // mode:'development',
    plugins:[
        new HtmlWebpackPlugin({
            template: 'index.html'
        })
    ]
}