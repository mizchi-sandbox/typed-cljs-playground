(ns main
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :as async :refer [>! <! put! timeout chan]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [foo.t :as t]))
(enable-console-print!)

(def app-state (atom {:text "Hello" :cnt 0}))

(defn countup []
  (swap! app-state
         update-in
         [:cnt]
         inc))

(defn app [state owner]
  (reify
    om/IRenderState
    (render-state [this s]
      (let [text (state :text)]
        (dom/div nil
          (dom/h1 nil text)
          (dom/button #js {:onClick countup} "countup")
          (dom/span nil (state :cnt)))))))

(.addEventListener js/window "DOMContentLoaded"
  #(let [el (.querySelector js/document "#app")]
    (om/root app app-state {:target el})))

; (def app-state (atom {:items []}))
;
; (defn list-view [app owner]
;   (let [items   (:items @app-state)
;         onClick #(swap! app-state
;                         assoc :items
;                         (conj items (count items)))]
;     (reify
;       om/IRenderState
;       (render-state [this state]
;         (dom/div nil
;           (dom/button #js {:onClick onClick} "Add item")
;           (apply dom/ul nil
;             (map (fn [text]
;               (dom/li nil text))
;               (:items app))))))))
;
; (.addEventListener js/window "DOMContentLoaded"
;   #(let [el (.querySelector js/document "#app")]
;     (println "initialized")
;     (om/root list-view app-state {:target el})))

    ; (add-watch app-state :items
    ;   (fn [_ _ _ state]
    ;     (println "items changed" state)
    ;     ))

; (defn click-chan [el]
;   (let [out (chan)]
;     (.addEventListener el "click" #(put! out "clicked"))
;     out))
; (.addEventListener js/window "load"
;   #(let [
;     el (.. js/window -document -body)
;     ch (click-chan el)]
;     (go
;       (while true
;         (let [v (<! ch)] (println "Read: " v))))))
