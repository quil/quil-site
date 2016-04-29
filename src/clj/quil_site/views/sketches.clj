(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]))

(defn sketch-page [id local?]
  (page {:tab :create
         :type :sketch
         :container-class "container-fluid"
         :title (str "Quil " id)
         :css-files ["/css/codemirror-5.12.css"
                     "/css/codemirror-5.12-lint.css"]
         :js-files ["/js/codemirror-5.12-clojure_lint_matchbrackets_closebrackets.js"
                    "/js/editor.js"]}

        [:div
         [:div.btn-group
          [:button#send.btn.btn-primary
           {:data-toggle "tooltip"
            :data-placement "bottom"
            :title "Run sketch. Use Ctrl+Enter to eval selected code or eval a form under cursor."}
           "Run"]
          [:button#reset.btn
           {:data-toggle "tooltip"
            :data-placement "bottom"
            :title "Reset drawing area. Doesn't affect code."}
           "Clear"]
          [:button#hide.btn.disabled
           {:data-toggle "tooltip"
            :data-placement "bottom"
            :title "Hide drawing area revealing editor."}
           "Hide"]
          [:button#share.btn
           {:data-toggle "tooltip"
            :data-placement "bottom"
            :title "Share sketch via URL."}
           "Share"]]
         [:dev#result-status.alert
          {:role "alert"}]]

        [:div#content
         [:div#source-content
          [:img#sketch-loading {:src "/img/sketch_loading.gif"}]
          [:div.hidden
           [:textarea#source
            {:data-sketch-id id
             :data-is-local (str local?)}]]]
         [:div#result-content
          {:style "width: 0px;"}
          [:iframe {:src "/iframe.html"
                    :width "0"
                    :height "0"}]]]

        [:div.modal.fade
         {:tabindex "-1"
          :id "share-dialog"
          :role "dialog"}
         [:div.modal-dialog.modal-sm
          [:div.modal-content
           [:div.modal-header
            [:button.close
             {:type "button"
              :data-dismiss "modal"
              :aria-label "Close"}
             [:span {:aria-hidden "true"} "&times"]]
            [:h4.modal-title "Share URL"]]
           [:div.modal-body
            [:input.form-control {:readonly "readonly"}]]]]]))
