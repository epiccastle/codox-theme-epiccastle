# codox-theme-epiccastle
A dark theme for codox. Use it as is or modify it to be a basis for your own dark theme.

## Using
Put the following in your `deps.edn` aliases. Adjust the details to your project:

```clojure
{:aliases
  {:codox {:extra-deps {codox/codox {:mvn/version "0.10.8"}
                       io.epiccastle/codox-theme-epiccastle {:mvn/version "0.1.0-SNAPSHOT"}}
          :exec-fn codox.main/generate-docs
          :exec-args {:source-paths ["src"]
                      :metadata {:doc/format :markdown}
                      :output-path "target/docs"
                      :doc-paths ["docs"]
                      :themes [:epiccastle]
                      :name "my-project"
                      :version "0.1.0-SNAPSHOT"
                      :description "my-description"}
          :extra-paths ["codox-processed/bb" "resources"]}
  }
}
```

and then

```
$ clj -X:codox
```

## Ad-hoc derivative
Copy all of `resources/` into your resources and remove the `io.epiccastle/codox-theme-epiccastle` dep and you should be able to edit the files and make your own derivative.

## Building jar
```bash-shell
$ make clean jar
clj -T:build clean
clj -T:build jar
$ jar tf target/codox-theme-epiccastle-0.1.0-SNAPSHOT.jar
META-INF/MANIFEST.MF
codox/
META-INF/
build.clj
codox/theme/
META-INF/maven/
codox/theme/epiccastle/
META-INF/maven/io.epiccastle/
codox/theme/epiccastle/theme.edn
codox/theme/epiccastle/css/
codox/theme/epiccastle/js/
codox/theme/epiccastle/highlight/
META-INF/maven/io.epiccastle/codox-theme-epiccastle/
codox/theme/epiccastle/css/dark.css
codox/theme/epiccastle/js/jquery.min.js
codox/theme/epiccastle/js/page_effects.js
codox/theme/epiccastle/highlight/highlight.min.js
codox/theme/epiccastle/highlight/LICENSE
codox/theme/epiccastle/highlight/tomorrow-night.css
META-INF/maven/io.epiccastle/codox-theme-epiccastle/pom.xml
META-INF/maven/io.epiccastle/codox-theme-epiccastle/pom.properties
```
