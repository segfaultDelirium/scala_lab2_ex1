def printInventoryItem(item: (String, Int)) = {
  val padded_item = item._1.padTo(30, ' ');
  println(s"${padded_item}\t ${item._2}")
}

def getItemsToOrder(inventory: List[(String, Int)]) = {
  inventory.filter(item => item._2 < 10)
}

def updateInventoryItem(
    inventory: List[(String, Int)],
    newItem: (String, Int)
) = {
  val newInventory = inventory
    .filter(item => item._1 != newItem._1)
  newInventory.appended(newItem)
}

def printInventory(inventory: List[(String, Int)]) = {
  inventory.foreach(item => printInventoryItem(item))
}

@main def main: Unit = {

  val inventory = List(
    ("rose while star", 12),
    ("sunflower", 3),
    ("orchid", 7),
    ("carnation white", 30),
    ("carnation red", 25)
  )

  println(s"inventory: ${inventory}");

  inventory.foreach(item => printInventoryItem(item))

  val itemsToOrder = getItemsToOrder(inventory);
  println();
  println("items to order:")
  itemsToOrder.foreach(printInventoryItem(_));
  println();

  val newInventory = updateInventoryItem(inventory, ("sunflower", 16));
  println("new inventory after sunflower order arrived: ");
  printInventory(newInventory)

}
