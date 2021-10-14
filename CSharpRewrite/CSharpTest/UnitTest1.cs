using System;
using System.Collections.Generic;
using System.Linq;
using CSharpRewrite.Assignments.Extra;
using NUnit.Framework;

namespace CSharpTest;

public class Tests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void TestPlus()
    {
        Assert.AreEqual(5.0f, Rpn.Run("2 3 +"));
    }
    
    [Test]
    public void TestMinus()
    {
        Assert.AreEqual(87.0f, Rpn.Run("90 3 -"));
    }

    [Test]
    public void TestMultiply()
    {
        Assert.AreEqual(-4.0f, Rpn.Run("10 4 3 + 2 * -"));
    }
    
    [Test]
    public void TestDivide()
    {
        Assert.AreEqual(-2.0f, Rpn.Run("10 4 3 + 2 * - 2 /"));
    }

    [Test]
    public void TestBadInput()
    {
        Assert.IsNull(Rpn.Run("90 34 12 33 55 66 + * - +"));
    }
    
    [Test]
    public void TestComplexInput()
    {
        Assert.AreEqual(4037.0f, Rpn.Run("90 34 12 33 55 66 + * - + -"));
    }

    [Test]
    public void TestPower()
    {
        Assert.AreEqual(8.0f, Rpn.Run("2 3 ^"));
    }
    
    [Test]
    public void TestSqrt()
    {
        Assert.AreEqual(MathF.Sqrt(2.0f), Rpn.Run("2 0.5 ^"));
    }
    
    [Test]
    public void TestLn()
    {
        Assert.AreEqual(MathF.Log(2.7f), Rpn.Run("2.7 ln"));
    }
    
    [Test]
    public void TestLog10()
    {
        Assert.AreEqual(MathF.Log10(2.7f), Rpn.Run("2.7 log10"));
    }
    
    [Test]
    public void TestSum()
    {
        Assert.AreEqual(50.0f, Rpn.Run("10 10 10 20 sum"));
    }
    
    [Test]
    public void TestSumAndDivide()
    {
        Assert.AreEqual(10.0f, Rpn.Run("10 10 10 20 sum 5 /"));
    }
    
    [Test]
    public void TestProduct()
    {
        Assert.AreEqual(1000.0f, Rpn.Run("10 10 20 0.5 prod"));
    }

    [Test]
    public void TestHeathrowToLondon()
    {
        var expectedRoad = new List<(char, int)>()
        {
            ('b', 10),
            ('x', 30),
            ('a', 5),
            ('x', 20),
            ('b', 2),
            ('b', 8),
        };

        Assert.AreEqual(expectedRoad, Road.Run().ToList());
    }
}