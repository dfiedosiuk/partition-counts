import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import Exercise._

class ExerciseSpec extends AnyFlatSpec with should.Matchers {

    behavior of "Partition counts"

    it should "return number of ways to partition given number" in {
      count(0) shouldBe 1
      count(1) shouldBe 1
      count(2) shouldBe 2
      count(3) shouldBe 3
      count(4) shouldBe 5
      count(5) shouldBe 7
      count(6) shouldBe 11
      count(7) shouldBe 15
      count(8) shouldBe 22
      count(9) shouldBe 30
      count(10) shouldBe 42
      count(11) shouldBe 56
      count(66) shouldBe 2323520
    }
}
