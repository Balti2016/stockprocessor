# Introduction #

StockProcessor? is an universal stock data processor for automation of technical analyzation.


# Details #

The main aim of project is an analyzer automat which can run continously or sheduled to generate transaction signals. The input of processor is in universal form, with some default implmentations (tipically for hungaryan stock exchange) but it can be easy extended or customized for personal needs. The output will be a simple GUI, an email notifyer, or an external application. The main processing library is customizable too. Defaultly it uses the TA-lib. It has a simple stock data visualizer GUI.

# Parts #
  * base library: the main elements and interfaces for processing and some helper abstract classes.
    1. API: the interfaces for external programs end extension libraryes
    1. common: helper and base classes
  * GUI: the visualiser library for the base
  * extensions: tools and implementations to realworld use. it contains importer implementations and calculator library