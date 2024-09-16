//
//  AboutScreen.swift
//  iosApp
//
//  Created by Johan Esteban Ordenes Galleguillos on 15-09-24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack {
            AboutListView()
                .navigationTitle("About Screen")
        }
    }
}

#Preview {
    AboutScreen()
}
