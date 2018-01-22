import java.util.concurrent.atomic.AtomicLong
import java.util.function
import java.util.function.{LongUnaryOperator, UnaryOperator}

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

object AtomicLongCounter {
  val lastNumber = new AtomicLong()
  def next: Long = {
    val nextNumber:Long =lastNumber.updateAndGet(new LongUnaryOperator {
      override def applyAsLong(operand: Long): Long = operand +1
    })
    nextNumber
  }
}
