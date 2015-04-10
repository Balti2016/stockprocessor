# Introduction #

This is not exactly a road-map, because the project is in very early state, so we only put some aims and good ideas to be followed


# TODO #

  * create the xml reader module (than can be used manually created xmls)
    * reader in progress
    * handle the optional parameters for inner processors
      * show on main processor
      * read values from xml
  * create the xml creator GUI & saver module

  * migrate _Broker_ object into _[DataProcessor](DataHandler#Data_Processor.md)_
  * fix: chart/element remove window
  * new: chart element types for source types (int, candle, action, etc.) to visualize
    * in progress... :)
    * new types/ideas? -new Action with icons
  * multi level signals:
    * Strong Buy
    * Buy
    * none
    * Sell
    * Strong Sell
  * new view on position handler:
    * 4 lines:
      * Open Long
      * Close Long
      * Open short
      * Close Short
    * no need to change the XML format...

# Finished TODOs #

  * fix library usage:
    * visualize the library of processors on GUI
  * recreate full hierarchy for maven compatibility, separate to multiple modules in one project
  * refact handlers to use queue - DECLINED handlers can use queues only if it is required... commonly they are notified by a simple method with input channels name.
  * new: chart element types for source types (int, candle, action, etc.) to visualize
    * Number, Candle, Action are finished
  * fix library usage:
    * centralize the management into main project (source, receiver, processor)