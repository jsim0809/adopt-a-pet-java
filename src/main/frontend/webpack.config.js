let WriteFilePlugin = require('write-file-webpack-plugin');

var webpack = require('webpack');
const path = require('path');

module.exports = {
  entry: {
    path: './src/main.js'
  },
  output: {
    path: path.join(__dirname, '../../../target/classes/static'),
    filename: "bundle.js"
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      }
    ]
  },
  plugins: [
    new WriteFilePlugin()
  ],
  devtool: 'eval-source-map',
  devServer: {
    contentBase: './public',
    inline: true
  }
}
