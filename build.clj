(ns build
  (:require [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as deps-deploy]))

(def lib 'io.epiccastle/codox-theme-epiccastle)
(def version "0.1.0-SNAPSHOT")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))
(def copy-srcs ["src" "resources"])

(defn clean [params]
  (b/delete {:path "target"})
  params)

(defn jar [{:keys [env] :as params}]
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["resources"]})
  (b/copy-dir {:src-dirs copy-srcs
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file})
  params)

(defn upload [_]
  (deps-deploy/deploy
   {:installer :remote
    :artifact jar-file
    :pom-file (b/pom-path {:lib lib :class-dir class-dir})}))
