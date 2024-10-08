semanticdbEnabled := false

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.6.1")
addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "1.1.4")
// addSbtPlugin("io.get-coursier" % "sbt-shading" % "2.1.5")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.0.0-RC1")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.13.0")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
