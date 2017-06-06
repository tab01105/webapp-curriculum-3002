import java.security.MessageDigest

object LockObjectMain2 extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(HashDigestProvider1.digest("Hello!"))).start()
  }

}

object HashDigestProvider2 {
  private[this] val md = MessageDigest.getInstance("SHA-1")

  def digest(str: String): List[Byte] = {
    md.reset()
    md.update(str.getBytes)
    md.digest().toList
  }

}
